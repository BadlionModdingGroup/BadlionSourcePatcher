package io.github.BadlionModdingGroup.sourcepatcher;

import com.cloudbees.diff.ContextualPatch;
import com.cloudbees.diff.PatchException;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException, PatchException {
        patchFile(null, null);
    }

    public static void patchFile(File file, File patchFile) throws IOException, PatchException {
        verifyPatch(file, patchFile);
        ContextualPatch patch = ContextualPatch.create(patchFile, file);
        patch.patch(true);
    }

    public static boolean verifyPatch(File file, File patchFile) throws IOException, PatchException {
        ContextualPatch patch = ContextualPatch.create(patchFile, file);
        List<ContextualPatch.PatchReport> patchReports = patch.patch(true);
        for (ContextualPatch.PatchReport report : patchReports) {
            System.out.println(report.getFailure());
        }
    }

}
