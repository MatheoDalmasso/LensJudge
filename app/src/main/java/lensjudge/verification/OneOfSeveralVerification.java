package lensjudge.verification;

import java.io.*;
import java.util.ArrayList;

/**
 * The OneOfSeveralVerification class implements the IVerification interface and provides
 * methods to verify if a line from an input stream matches any line in a specified file.
 */
public class OneOfSeveralVerification implements IVerification {

    /**
     * Checks if the file at the given path is not empty.
     *
     * @param pathFileIn the path to the file
     * @return true if the file is not empty, false otherwise
     */
    @Override
    public boolean isNotEmpty(String pathFileIn) {
        if (isFileExists(pathFileIn)) {
            File fileIn = new File(pathFileIn);
            return fileIn.length() > 0;
        }
        return false;
    }

    /**
     * Checks if the file at the given path exists.
     *
     * @param pathFileIn the path to the file
     * @return true if the file exists, false otherwise
     */
    @Override
    public boolean isFileExists(String pathFileIn) {
        File fileIn = new File(pathFileIn);
        return fileIn.exists();
    }

    /**
     * Verifies if a line from the input stream matches any line in the file at the given path.
     *
     * @param input the input stream to verify
     * @param pathFileOut the path to the file to compare against
     * @return the result of the verification
     */
    @Override
    public TypeVerification verify(InputStream input, String pathFileOut) {
        if (isNotEmpty(pathFileOut)) {
            try {
                File fileOut = new File(pathFileOut);
                BufferedReader br = new BufferedReader(new InputStreamReader(input));
                BufferedReader br2 = new BufferedReader(new FileReader(fileOut));
                String lineIn;
                String lineOut;
                ArrayList<String> arrOut = new ArrayList<>();
                while ((lineOut = br2.readLine()) != null) {
                    arrOut.add(lineOut);
                }
                lineIn = br.readLine();
                if (arrOut.contains(lineIn)) {
                    return TypeVerification.CORRECT;
                }
                return TypeVerification.WRONG;
            } catch (IOException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        return TypeVerification.WRONG;
    }
}