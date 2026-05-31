/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.apple.eio.FileManager
 */
package com.badlogic.gdx.backends.lwjgl3;

import com.apple.eio.FileManager;
import com.badlogic.gdx.Net;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.badlogic.gdx.net.NetJavaImpl;
import com.badlogic.gdx.net.NetJavaServerSocketImpl;
import com.badlogic.gdx.net.NetJavaSocketImpl;
import com.badlogic.gdx.net.ServerSocket;
import com.badlogic.gdx.net.ServerSocketHints;
import com.badlogic.gdx.net.Socket;
import com.badlogic.gdx.net.SocketHints;
import com.badlogic.gdx.utils.SharedLibraryLoader;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;

public class Lwjgl3Net
implements Net {
    NetJavaImpl netJavaImpl;

    public Lwjgl3Net(Lwjgl3ApplicationConfiguration configuration) {
        this.netJavaImpl = new NetJavaImpl(configuration.maxNetThreads);
    }

    @Override
    public void sendHttpRequest(Net.HttpRequest httpRequest, Net.HttpResponseListener httpResponseListener) {
        this.netJavaImpl.sendHttpRequest(httpRequest, httpResponseListener);
    }

    @Override
    public void cancelHttpRequest(Net.HttpRequest httpRequest) {
        this.netJavaImpl.cancelHttpRequest(httpRequest);
    }

    @Override
    public ServerSocket newServerSocket(Net.Protocol protocol, String ipAddress, int port, ServerSocketHints hints) {
        return new NetJavaServerSocketImpl(protocol, ipAddress, port, hints);
    }

    @Override
    public ServerSocket newServerSocket(Net.Protocol protocol, int port, ServerSocketHints hints) {
        return new NetJavaServerSocketImpl(protocol, port, hints);
    }

    @Override
    public Socket newClientSocket(Net.Protocol protocol, String host, int port, SocketHints hints) {
        return new NetJavaSocketImpl(protocol, host, port, hints);
    }

    @Override
    public boolean openURI(String URI2) {
        if (SharedLibraryLoader.isMac) {
            try {
                FileManager.openURL((String)URI2);
                return true;
            }
            catch (IOException e) {
                return false;
            }
        }
        try {
            Desktop.getDesktop().browse(new URI(URI2));
            return true;
        }
        catch (Throwable t) {
            return false;
        }
    }
}

