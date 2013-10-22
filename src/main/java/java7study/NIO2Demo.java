package java7study;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * User: jinyanhua
 * Date: 13-10-22
 * Time: 上午9:46
 */
public class NIO2Demo {
    public static void main(String[] args) {
        NIO2Demo demo = new NIO2Demo();
        demo.walkDirectory("C:/Document/Dropbox");
        demo.directoryWatcher("C:/Users/jinyanhua/Desktop");
    }

    public void walkDirectory(String filePath){
        Path path = Paths.get(filePath);
        Path root = path.getRoot();
        System.out.println(root.toString());
        System.out.println("Now, we are here:"+path);
        showFileTree(path);
    }

   private void showFileTree(Path p){
       try {
           Files.walkFileTree(p,new FileVisitor<Path>(){

               @Override
               public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                   System.out.println("Dir:"+dir);
                   return FileVisitResult.CONTINUE;
               }

               @Override
               public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                   System.out.println("File:"+file);
                   return FileVisitResult.CONTINUE;
               }

               @Override
               public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
                   System.out.println("ERROR:"+file);
                   return FileVisitResult.CONTINUE;
               }

               @Override
               public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                   //System.out.println("ERROR:"+dir);
                   return FileVisitResult.CONTINUE;
               }
           });
       } catch (IOException e) {
           e.printStackTrace();
       }
   }

    public void directoryWatcher(String path){
        try {
            Path p = Paths.get(path);
            WatchService ws = p.getFileSystem().newWatchService();
            p.register(ws, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_MODIFY, StandardWatchEventKinds.ENTRY_DELETE);
            while (true){
                WatchKey watchKey = ws.take();
                for (WatchEvent event : watchKey.pollEvents()) {
                    System.out.println(event.kind() + " : " + event.context());
                    watchKey .reset();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
