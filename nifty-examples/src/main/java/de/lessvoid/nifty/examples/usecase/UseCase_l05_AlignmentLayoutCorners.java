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

import de.lessvoid.nifty.Nifty;
import de.lessvoid.nifty.node.NiftyReferenceNode;
import de.lessvoid.nifty.types.NiftyColor;

import static de.lessvoid.nifty.node.AlignmentLayoutChildNode.alignmentLayoutChildNode;
import static de.lessvoid.nifty.node.AlignmentLayoutNode.alignmentLayoutNode;
import static de.lessvoid.nifty.node.Horizontal.Left;
import static de.lessvoid.nifty.node.Horizontal.Right;
import static de.lessvoid.nifty.node.NiftyBackgroundColorNode.backgroundColorNode;
import static de.lessvoid.nifty.node.NiftyContentNode.contentNode;
import static de.lessvoid.nifty.node.SizeLayoutNode.fixedSizeLayoutNode;
import static de.lessvoid.nifty.node.Vertical.Bottom;
import static de.lessvoid.nifty.node.Vertical.Top;

/**
 * This is a simple example of the alignment layout node.
 * <p />
 * This layout is expected to display 4 squares in each corner of the screen.
 * <ul>
 *  <li>Top Left: Red</li>
 *  <li>Top Right: Green</li>
 *  <li>Bottom Left: Blue</li>
 *  <li>Bottom Right: Yellow</li>
 * </ul>
 *
 * @author Martin Karing &lt;nitram@illarion.org&gt;
 */
public final class UseCase_l05_AlignmentLayoutCorners {
  public UseCase_l05_AlignmentLayoutCorners(final Nifty nifty) {
    nifty
        .addNode(alignmentLayoutNode())
          .addNode(NiftyReferenceNode.referenceNode("alignmentNode"))
            .addNode(alignmentLayoutChildNode(Left, Top))
              .addNode(fixedSizeLayoutNode(100.f, 100.f))
                .addNode(backgroundColorNode(NiftyColor.red()))
                  .addNode(contentNode())
          .addAsChildOf("alignmentNode")
            .addNode(alignmentLayoutChildNode(Right, Top))
              .addNode(fixedSizeLayoutNode(100.f, 100.f))
                .addNode(backgroundColorNode(NiftyColor.green()))
                  .addNode(contentNode())
          .addAsChildOf("alignmentNode")
            .addNode(alignmentLayoutChildNode(Left, Bottom))
              .addNode(fixedSizeLayoutNode(100.f, 100.f))
                .addNode(backgroundColorNode(NiftyColor.blue()))
                  .addNode(contentNode())
          .addAsChildOf("alignmentNode")
            .addNode(alignmentLayoutChildNode(Right, Bottom))
              .addNode(fixedSizeLayoutNode(100.f, 100.f))
                .addNode(backgroundColorNode(NiftyColor.yellow()))
                  .addNode(contentNode());
  }

  public static void main(final String[] args) throws Exception {
    UseCaseRunner.run(UseCase_l05_AlignmentLayoutCorners.class, args);
  }
}
