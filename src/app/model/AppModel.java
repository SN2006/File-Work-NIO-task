package app.model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class AppModel {

    public String readFile(String path){
        try{
            Path fileToRead = handlePath(path);
            if (isNotExistsFile(fileToRead)){
                return "There is no file with that name '%s'"
                        .formatted(fileToRead.getFileName());
            }
            return Files.readString(fileToRead);
        } catch (IOException e) {
            return "Something went wrong: " + e.getMessage();
        }
    }

    public String writeToFile(String path, String content){
        try{
            Path newFile = handlePath(path);
            if (isNotExistsFile(newFile)){
                Files.createFile(newFile);
            }
            Files.writeString(newFile, content);
            return "File %s was created successfully".formatted(newFile.getFileName());
        } catch (IOException e) {
            return "Something went wrong: " + e.getMessage();
        }
    }

    public String deleteFile(String path){
        try{
            Path fileToDelete = handlePath(path);
            if (isNotExistsFile(fileToDelete)){
                return "There is no file with that name '%s'"
                        .formatted(fileToDelete.getFileName());
            }
            Files.delete(fileToDelete);
            return "File %s was deleted".formatted(fileToDelete.getFileName());
        } catch (IOException e) {
            return "Something went wrong: " + e.getMessage();
        }
    }

    public String renameFile(String oldPath, String newPath){
        try {
            Path fileToRename = handlePath(oldPath);
            Path fileWithNewName = handlePath(newPath);
            if (isNotExistsFile(fileToRename)){
                return "There is no file with that name '%s'"
                        .formatted(fileToRename.getFileName());
            }
            Files.move(fileToRename, fileWithNewName);
            return "The file has been successfully modified";
        } catch (IOException e) {
            return "Something went wrong: " + e.getMessage();
        }
    }

    private Path handlePath(String path){
        return Path.of(path);
    }

    private boolean isNotExistsFile(Path path){
        return !Files.exists(path);
    }

}
