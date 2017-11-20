package com.vik.windows.issues;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

public class TestFileLock {

    public static void main(final String[] args) throws IOException {

        // Below code doesn't work on windows. Because of file locking.
        // File tempFile = File.createTempFile("testing_file", ".txt");
        // System.out.println("File path : " + tempFile.getAbsolutePath());
        // try (RandomAccessFile randomAccess = new RandomAccessFile(tempFile, "rw"); FileLock lock = randomAccess.getChannel().lock()) {
        // try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(tempFile))) {
        // bos.write(UUID.randomUUID().toString().getBytes());
        // }
        // }

        File tempFile = File.createTempFile("testing_file", ".txt");
        System.out.println("File Path : " + tempFile.getAbsolutePath());

        try (RandomAccessFile randomAccess = new RandomAccessFile(tempFile, "rw"); FileOutputStream fos = new FileOutputStream(tempFile)) {
            FileChannel channel = fos.getChannel();
            FileLock lock = channel.lock();
            try (BufferedOutputStream bos = new BufferedOutputStream(fos)) {
                bos.write("Hello World !!".getBytes());
            }
            lock.close();
        }

    }

}
