package com.vik.windows.issues;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.Set;

public class CreateFileWithPermissions {

    public static void createTempFileForLinux() throws IOException {
        // only works for linux
        Path path = Files.createTempFile("temp_linux_file", ".txt",
                PosixFilePermissions.asFileAttribute(PosixFilePermissions.fromString("rw-------")));
        System.out.println("Path is : " + path.toFile().getAbsolutePath());
    }

    public static Set<String> checkFileSystems() {
        Set<String> supported = FileSystems.getDefault().supportedFileAttributeViews();
        System.out.println(supported);
        return supported;
    }

}
