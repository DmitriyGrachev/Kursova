package View;
import java.io.*;
import Exception.*;
import Interface.*;

public class FileView implements View, localResult {
    private String path;

    public FileView(String path) {
        this.path = path;
    }

    @Override
    public void print(String text) throws DispatchException {
        localResult();
        File file = new File(path, "result.txt");
        try (OutputStream outputStream = new FileOutputStream(file, true)) {
            outputStream.write(text.getBytes());
        } catch (IOException e) {
            throw new DispatchException("ERROR");
        } catch(RuntimeException e){
            e.printStackTrace();
        }
    }

    @Override
    public void localResult() {
        try {
            if (new File(path).isFile()) {
                path = new File(path).getParent();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
