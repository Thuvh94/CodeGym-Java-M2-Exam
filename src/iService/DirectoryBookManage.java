package iService;

import model.DirectoryBook;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DirectoryBookManage implements iManage<DirectoryBook> {
    static List<DirectoryBook> directoryBookList = new ArrayList<>();
    static{
        //public DirectoryBook(String name, long phoneNumber, String group, boolean isMale, String address, LocalDate birthday, String email)
        directoryBookList.add(new DirectoryBook("Ha",913970994L,"CodeGym",false,"HaNoi",LocalDate.parse("1994-10-23"),"thuvh@gmail.com"));
    }
    @Override
    public void add(DirectoryBook item) {
        if(!isExisted(item.getPhoneNumber()))
            directoryBookList.add(item);
    }

    @Override
    public void update(long phone, DirectoryBook item) {
        if(isExisted(phone)){
            for (int i = 0; i < directoryBookList.size(); i++) {
                if(directoryBookList.get(i).getPhoneNumber() == phone){
                    directoryBookList.set(i,item);
                }
            }
        }
    }

    @Override
    public List<DirectoryBook> delete(long phone) {
        if(isExisted(phone)){
            for (int i = 0; i < directoryBookList.size(); i++) {
                if(directoryBookList.get(i).getPhoneNumber()==phone){
                    directoryBookList.remove(directoryBookList.get(i));
                }
            }
        }
        return directoryBookList;
    }

    @Override
    public List<DirectoryBook> findAll() {
        return directoryBookList;
    }

    @Override
    public DirectoryBook findByPhone(long phone) {
        if(isExisted(phone)){
            for (int i = 0; i < directoryBookList.size(); i++) {
                if(directoryBookList.get(i).getPhoneNumber()==phone)
                    return directoryBookList.get(i);
            }
        }
        return null;
    }

    @Override
    public List<DirectoryBook> findByName(String name) {
        List<DirectoryBook> list = new ArrayList<>();
        for (int i = 0; i < directoryBookList.size(); i++) {
            if(directoryBookList.get(i).getName().equals(name)){
                list.add(directoryBookList.get(i));
            }
        }
        return list;
    }

    public boolean isExisted(long phone){
        for (DirectoryBook book: directoryBookList) {
            if(book.getPhoneNumber()==phone) {
                return true;
            }
        }
        return false;
    }

    public void readFile(){
        try {
            FileReader file = new FileReader("data/contacts.csv");
            BufferedReader bf = new BufferedReader(file);

            String line = null;
            String[] directoryBookString;
            while((line = bf.readLine())!=null){
                directoryBookString = line.split(",");
                DirectoryBook directoryBookFromFile = new DirectoryBook();
                String phoneString = directoryBookString[0];
                Long phone = Long.parseLong(phoneString);
                String group = directoryBookString[1];
                String name = directoryBookString[2];
                String sexType = directoryBookString[3];
                boolean isMale = false;
                if(sexType.equals("Nam")){
                    isMale = true;
                }
                else if  (sexType.equals("Nữ")){
                    isMale = false;
                }
                String address = directoryBookString[4];
                String birthdayString = directoryBookString[5];
                LocalDate birthday = LocalDate.parse(birthdayString);
                String mail = directoryBookString[6];
                DirectoryBook book = new DirectoryBook(name,phone,group,isMale,address,birthday,mail);
                directoryBookList.add(book);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void writeFile(List list){
        try {
            FileWriter file = new FileWriter("data/contacts.csv");
            //while ((length = inputFile.read(bt)) > 0)
            for (int i = 0; i < directoryBookList.size(); i++) {
                  file.write(directoryBookList.get(i).toString());
            }
           file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    public List<DirectoryBook> getDirectoryBookList() {
//        return directoryBookList;
//    }
//
//    public void setDirectoryBookList(List<DirectoryBook> directoryBookList) {
//        this.directoryBookList = directoryBookList;
//    }
}
