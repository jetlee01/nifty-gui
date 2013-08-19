package de.lessvoid.nifty.examples.usecase;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.logging.Logger;

import de.lessvoid.coregl.CoreLwjglSetup;
import de.lessvoid.coregl.CoreLwjglSetup.RenderLoopCallback2;
import de.lessvoid.nifty.api.Nifty;
import de.lessvoid.nifty.api.NiftyStatistics.FrameInfo;
import de.lessvoid.nifty.renderer.lwjgl.NiftyRenderDeviceLwgl;

public class RunUseCaseLwjglMain {
  private static Logger log = Logger.getLogger(RunUseCaseLwjglMain.class.getName());
  private static float time;

  public static void main(final String[] args) throws Exception {
    if (args.length != 1) {
      System.err.println("Expected use case classname (without package name) to run.");
      System.err.println("Example: " + RunUseCaseLwjglMain.class.getName() + " UseCase_0001_FullScreenColorNode");
      System.exit(1);
    }

    // init LWJGL using some helper class
    CoreLwjglSetup setup = new CoreLwjglSetup();
    setup.initializeLogging("/logging.properties");
    setup.initialize(caption(args), 1024, 768);

    // create nifty instance
    final Nifty nifty = createNifty();

    final Object useCase = loadUseCase(args[0], nifty);
    logScene(nifty);

    setup.renderLoop2(new RenderLoopCallback2() {
      @Override
      public boolean render(final float deltaTime) {
        updateUseCase(nifty, useCase, deltaTime);
        nifty.update();

        boolean frameChanged = nifty.render();
        outputStatistics(nifty, deltaTime);
        return frameChanged;
      }

      private void updateUseCase(final Nifty nifty, final Object useCase, final float deltaTime) {
        if (!(useCase instanceof Updateable)) {
          return;
        }
        ((Updateable) useCase).update(nifty, deltaTime);
      }

      @Override
      public boolean shouldEnd() {
        return false;
      }
    });
  }

  private static String caption(final String[] args) {
    return "Nifty 2.0 (" + args[0] + ")";
  }

  private static Object loadUseCase(final String clazzName, final Nifty nifty) throws Exception {
    Class<?> clazz = ClassLoader.getSystemClassLoader().loadClass(
        RunUseCaseLwjglMain.class.getPackage().getName() + "." + clazzName);
    log.info("loaded class [" + clazz + "]");

    return clazz.getConstructor(Nifty.class).newInstance(nifty);
  }

  private static void logScene(final Nifty nifty) {
    log.info(nifty.getSceneInfoLog());
  }

  private static Nifty createNifty() {
    return new Nifty(new NiftyRenderDeviceLwgl());
  }

  private static void outputStatistics(final Nifty nifty, final float deltaTime) {
    time += deltaTime;
    if (time >= 1000) {
      time = 0;

      FrameInfo[] frameInfos = nifty.getStatistics().getAllSamples();
      StringBuilder stuff = new StringBuilder("Nifty Stats\n");
      stuff.append("     frame    update     render      synch\n");
      for (FrameInfo frameInfo : frameInfos) {
        stuff.append(String.format("%10s", frameInfo.getFrame()));
        stuff.append(formatValue(frameInfo.getUpdateTime())).append(" ");
        stuff.append(formatValue(frameInfo.getRenderTime())).append(" ");
        stuff.append(formatValue(frameInfo.getSyncTime()));
        stuff.append("\n");
      }
      log.info(stuff.toString());
    }
  }

  private static String formatValue(final long value) {
    if (value == -1) {
      return "N/A";
    }
    NumberFormat format = NumberFormat.getInstance(Locale.US);
    format.setGroupingUsed(false);
    format.setMinimumFractionDigits(4);
    format.setMaximumFractionDigits(4);
    return String.format("%10s", format.format(value / 100000.f));
  }

}
