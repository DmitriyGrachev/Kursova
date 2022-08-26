package Interface;

import java.io.IOException;

import Exception.DispatchException;

public interface View {
    public void print(String text) throws IOException, DispatchException;
}
