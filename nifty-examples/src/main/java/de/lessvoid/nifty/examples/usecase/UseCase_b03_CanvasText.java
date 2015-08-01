/*
 * Copyright (c) 2015, Nifty GUI Community 
 * All rights reserved. 
 * 
 * Redistribution and use in source and binary forms, with or without 
 * modification, are permitted provided that the following conditions are 
 * met: 
 * 
 *  * Redistributions of source code must retain the above copyright 
 *    notice, this list of conditions and the following disclaimer. 
 *  * Redistributions in binary form must reproduce the above copyright 
 *    notice, this list of conditions and the following disclaimer in the 
 *    documentation and/or other materials provided with the distribution. 
 * 
 * THIS SOFTWARE IS PROVIDED BY THE AUTHOR AND CONTRIBUTORS ``AS IS'' AND 
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE 
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR 
 * PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE AUTHOR OR CONTRIBUTORS BE 
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR 
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF 
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS 
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN 
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) 
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF 
 * THE POSSIBILITY OF SUCH DAMAGE.
 */
package de.lessvoid.nifty.examples.usecase;

import java.io.IOException;

import de.lessvoid.nifty.api.ChildLayout;
import de.lessvoid.nifty.api.Nifty;
import de.lessvoid.nifty.api.NiftyCanvas;
import de.lessvoid.nifty.api.NiftyCanvasPainter;
import de.lessvoid.nifty.api.NiftyColor;
import de.lessvoid.nifty.api.NiftyFont;
import de.lessvoid.nifty.api.UnitValue;

/**
 * custom canvas painter rendering text
 * @author void
 */
public class UseCase_b03_CanvasText {
/* FIXME
  public UseCase_b03_CanvasText(final Nifty nifty) throws IOException {
    final NiftyFont font = nifty.createFont("fonts/aurulent-sans-16.fnt");

    NiftyNode niftyNode = nifty.createRootNode(UnitValue.px(400), UnitValue.px(400), ChildLayout.Center);
    niftyNode.setCanvasPainter(new NiftyCanvasPainter() {
      @Override
      public void paint(final NiftyNode node, final NiftyCanvas canvas) {
        canvas.setFillStyle(NiftyColor.blue());
        canvas.fillRect(0, 0, node.getWidth(), node.getHeight());

        canvas.setTextColor(NiftyColor.white());
        canvas.text(font, 10, 10, "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ");

        canvas.setTextColor(NiftyColor.red());
        canvas.setTextSize(1.2f);
        canvas.text(font, 10, 40, "abcdefghijklmnopqrstuvwxyz");

        canvas.setTextColor(NiftyColor.green());
        canvas.setTextSize(1.4f);
        canvas.text(font, 10, 70, "ABCDEFGHIJKLMNOPQRSTUVWXYZ");

        canvas.setTextColor(NiftyColor.yellow());
        canvas.setTextSize(1.6f);
        canvas.text(font, 10, 100, "0123456789");

        canvas.setTextColor(NiftyColor.white());
        canvas.setTextSize(2.0f);
        canvas.text(font, 10, 150, "ABC Hello Nifty 2.0 Text");
}
    });
  }

  public static void main(final String[] args) throws Exception {
    UseCaseRunner.run(UseCase_b03_CanvasText.class, args);
  }
  */
}
