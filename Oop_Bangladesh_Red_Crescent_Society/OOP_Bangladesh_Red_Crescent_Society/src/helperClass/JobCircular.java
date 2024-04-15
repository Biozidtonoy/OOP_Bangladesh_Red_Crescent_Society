/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package helperClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author tonoy
 */
public class JobCircular implements Serializable{
    public String post,time;
    public LocalDate deadline;
    public Double salary;

    public JobCircular(String post, String time, LocalDate deadline, Double salary) {
        this.post = post;
        this.time = time;
        this.deadline = deadline;
        this.salary = salary;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "JobCircular{" + "post=" + post + ", time=" + time + ", deadline=" + deadline + ", salary=" + salary + '}';
    }
    public boolean createJobCircular(JobCircular fb1) {

    
        System.out.println("JobCircular made:" + fb1.toString());

        File f = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {

            f = new File("JobCircular.bin");

            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutputStream(fos);

            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }
            fb1 = new JobCircular(post,time,deadline,salary);

            oos.writeObject(fb1);
            oos.close();
            return true;

        } catch (IOException e) {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException ex) {
                    Logger.getLogger(JobCircular.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            System.out.println("Error writing Object to binary file");
            return false;

        }
    }
//    ====>>>read bin files
    public static ObservableList<JobCircular> readJobCircularList1(){
        ObservableList<JobCircular> JobCircularList1 = FXCollections.observableArrayList();
        JobCircular fb3;
        ObjectInputStream ois = null;
        try{
            ois = new ObjectInputStream (new FileInputStream("JobCircular.bin"));
            while(true){
               fb3 = (JobCircular) ois.readObject();
                System.out.println("The job Circular u read: "+fb3.toString());
                JobCircularList1.add(fb3);
            }
        }
        catch(IOException | ClassNotFoundException e){System.out.println("File reading done");}
        System.out.println(JobCircularList1);
        return JobCircularList1;
    }
    
}
