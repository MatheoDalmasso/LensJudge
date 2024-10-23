package lensjudge.Execution;

import lensjudge.compilation.CompilerC;
import lensjudge.compilation.CompilerPython;
import lensjudge.process.ProcessAdapter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;

public class ExecutionPy implements IExecution {
     public ProcessAdapter execute(String sourceFilePath, String binaryFileName) {
         ProcessAdapter processAdapter = new ProcessAdapter("python3", sourceFilePath);
         return processAdapter;
    }
}
