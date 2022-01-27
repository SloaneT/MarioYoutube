package renderer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Shader {

    private int shaderProgramID;

    private String vertexSource;
    private String fragmentSource;
    private String filepath;

    // Separate function allows one to make sure file can be opened before attempting to compile
    public Shader(String filepath){
        this.filepath = filepath;
        try {
            String source = new String(Files.readAllBytes(Paths.get(filepath)));
            String[] splitString = source.split("(#type)()+([a-zA-Z]+)");
            // finds the first pattern after #type 'pattern'
            // does this by finding first index of #type along with index of the following word's first letter
            int index = source.indexOf("#type");
            int eol = source.indexOf("\r\n", index);
            // firstPattern distinguishes between vertex and fragment; trim() removes whitespace
            String firstPattern  = source.substring(index, eol).trim();

            // finds the second pattern after #type 'pattern'
            index = source.indexOf("#type", eol);
            eol = source.indexOf("\r\n", index);
            String secondPattern = source.substring(index, eol).trim();

            if (firstPattern.equals("vertex")) {
                vertexSource = splitString[1];
            } else if (firstPattern.equals("fragment")) {
                fragmentSource = splitString[1];
            } else {
                throw new IOException("Unexpected token '" + firstPattern + "'");
            }

            if (secondPattern.equals("vertex")) {
                vertexSource = splitString[1];
            } else if (secondPattern.equals("fragment")) {
                fragmentSource = splitString[1];
            } else {
                throw new IOException("Unexpected token '" + secondPattern + "'");
            }

        } catch(IOException e) {
            e.printStackTrace();
            assert false : "Error: Could not open file for shader: '" + filepath + "'";
        }
    }

    public void compile() {

    }

    public void use() {

    }

    public void detach() {

    }
}
