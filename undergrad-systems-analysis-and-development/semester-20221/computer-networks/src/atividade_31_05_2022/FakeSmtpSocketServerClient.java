package atividade_31_05_2022;

import java.io.*;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class FakeSmtpSocketServerClient {
    private String smtpHost;
    private int smtpPort;
    private Socket smtpSocket;
    private BufferedReader smtpIn;
    private PrintWriter smtpOut;
    private String lastInputLine = "";
    private boolean smtpDebug;

    public FakeSmtpSocketServerClient() {
        smtpDebug = false;
        smtpHost = null;
        smtpPort = 25;
    }

    public void setPort(int port) {
        smtpPort = port;
    }

    public int getPort() {
        return smtpPort;
    }

    public void setHost(String host) {
        smtpHost = host;
    }

    public String getHost() {
        return smtpHost;
    }

    public void setDebug(boolean debug) {
        smtpDebug = debug;
    }

    public boolean getDebug() {
        return smtpDebug;
    }

    public void sendMail(String msgTo, String msgFrom, String msgSubj, String msgBody) {
        try {
            smtpSocket = new Socket(smtpHost, smtpPort);
            try {
                smtpOut = new PrintWriter(smtpSocket.getOutputStream(), true);
                smtpIn = new BufferedReader(new InputStreamReader(smtpSocket.getInputStream()));
                if (!waitForResponse("220")) return;

                smtpOut.println("HELO VIRTUAL_LIST_SERVER");
                if (!waitForResponse("250")) return;

                smtpOut.println("MAIL FROM: " + msgFrom);
                if (!waitForResponse("250")) return;

                smtpOut.println("RCPT TO: " + msgTo);
                if (!waitForResponse("250")) return;

                smtpOut.println("DATA");
                if (!waitForResponse("354")) return;

                smtpOut.println("Subject: " + msgSubj);
                if (msgSubj != null) {
                    smtpOut.println(msgSubj);
                }
                smtpOut.println();
                if (msgBody != null) {
                    smtpOut.println(msgBody);
                }
                smtpOut.println(".");
                if (!waitForResponse("250")) return;

                smtpOut.println("QUIT");
                if (!waitForResponse("221")) return;
            } catch (IOException e) {
            }
            smtpSocket.close();
        } catch (IOException e) {
        }
    }

    protected boolean waitForResponse(String response) {
        String nextLine;
        if (smtpSocket == null) return false;
        while ((nextLine = getNextLine()) != null) {
            if (response.equals("*") || nextLine.startsWith(response)) return true;
            idle();
        }
        return false;
    }

    protected void idle() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
    }

    protected String getNextLine() {
        try {
            lastInputLine = smtpIn.readLine();
            if (smtpDebug) {
                System.out.println(lastInputLine);
            }
            return lastInputLine;
        } catch (IOException e) {
        }
        return null;
    }
    
    public static void main(String[] args) {
    	FakeSmtpSocketServerClient s = new FakeSmtpSocketServerClient();
        
        s.setDebug(true);
        
        s.setHost("");
        
        String msgTo = "";
        String msgFrom = "";
        String msgSubj = "test";
        String msgBody = "hello, world!";
        s.sendMail(msgTo, msgFrom, msgSubj, msgBody);
    }
}