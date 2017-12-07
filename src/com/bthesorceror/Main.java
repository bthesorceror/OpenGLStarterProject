package com.bthesorceror;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.*;

public class Main {
    private final static int width = 800;
    private final static int height = 600;

    public static void main(String[] args) throws LWJGLException {
        System.setProperty("org.lwjgl.opengl.Display.enableHighDPI", "true");
        ContextAttribs attribs = new ContextAttribs(3, 2)
          .withForwardCompatible(true)
          .withProfileCore(true);
        PixelFormat pixelFormat = new PixelFormat(8, 8, 0, 8);

        Display.create(pixelFormat, attribs);
        Display.sync(60);
        Display.setTitle("OpenGL Lunch and Learn");
        Display.setDisplayMode(new DisplayMode(width, height));
        Display.setVSyncEnabled(true);
        GL11.glEnable(GL11.GL_DEPTH_TEST);

        GL11.glViewport(
          0,
          0,
          (int)(width * Display.getPixelScaleFactor()),
          (int)(height * Display.getPixelScaleFactor()));

        while (!Display.isCloseRequested()) {
            Display.update();
        }

        Display.destroy();
    }
}
