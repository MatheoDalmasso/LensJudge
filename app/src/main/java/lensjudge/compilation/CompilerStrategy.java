package lensjudge.compilation;

import java.io.File;
import java.io.IOException;

public abstract class CompilerStrategy implements ICompilerStrategy {


    @Override
    public void compile(String sourceFileName, String languageSelected) throws IOException, InterruptedException {
        if (isCompatible(languageSelected)) {
            File sourceFile = new File(sourceFileName);
            String binaryFileName = getBinaryFileName(sourceFileName);
            executeCompilerCommand(sourceFile, binaryFileName);
        } else {
            throw new IllegalArgumentException("Language not supported or not found");
        }
    }
}