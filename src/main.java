import iService.DirectoryBookManage;
import model.DirectoryBook;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        DirectoryBookManage directoryBookManage = new DirectoryBookManage();
        List<DirectoryBook> list = new ArrayList<>();
        int choice = -1;
        Scanner sc = new Scanner(System.in);

        while (choice != 8) {
            displayMenuList();
            choice = Integer.parseInt(sc.next());
            switch (choice) {
                case 1:
                    System.out.println("====Xem danh sách====");
                    list = directoryBookManage.findAll();
                    System.out.println(list);
                    break;
                case 2:
                    System.out.println("===Lựa chọn thêm mới===");
                    System.out.println("Số điện thoại: ");
                    long phone = Long.parseLong(sc.next());
                    System.out.println("Nhập nhóm: ");
                    String group = sc.next();
                    System.out.println("Nhập họ tên: ");
                    String name = sc.next();
                    System.out.println("Giới tính Nam: 0 , Nữ: 1");
                    int sexType = sc.nextInt();
                    boolean isMale = false;
                    if (sexType == 0)
                        isMale = true;
                    else
                        isMale = false;
                    System.out.println("Nhập địa chỉ: ");
                    String address = sc.next();
                    System.out.println("Nhập email: ");
                    String email = sc.next();
                    System.out.println("Thêm mới thành công");
                    DirectoryBook addedDirectoryBook = new DirectoryBook(name, phone, group, isMale, address, email);
                    break;
                case 3:
                    System.out.println("===Cập nhật===");
                    System.out.println("Nhập số điện thoại cần sửa");
                    long inputPhone = Long.parseLong(sc.next());
                    if(directoryBookManage.isExisted(inputPhone)){
                        System.out.println("Nhập nhóm: ");
                        String updateGroup = sc.next();
                        System.out.println("Nhập họ tên: ");
                        String updateName = sc.next();
                        System.out.println("Giới tính Nam: 0 , Nữ: 1");
                        int updateSexType = sc.nextInt();
                        boolean updateIsMale = false;
                        if (updateSexType == 0)
                            updateIsMale = true;
                        else
                            updateIsMale = false;
                        System.out.println("Nhập địa chỉ: ");
                        String updateAddress = sc.next();
                        System.out.println("Nhập email: ");
                        String updateEmail = sc.next();
                        DirectoryBook updateDirectoryBook =
                                new DirectoryBook(updateName,inputPhone,updateGroup,updateIsMale,updateAddress,updateEmail);
                        directoryBookManage.update(inputPhone,updateDirectoryBook);
                        list = directoryBookManage.findAll();

                    }
                    else
                        System.out.println("Không tìm được danh bạ với số điện thoại trên. ");
                        break;
                case 4:
                    System.out.println("===Xóa danh bạ===");
                    System.out.println("Nhập số điện thoại cần xóa");
                    long deletePhone = Long.parseLong(sc.next());
                    directoryBookManage.delete(deletePhone);
                    list = directoryBookManage.findAll();

            }

        }


    }

    public static void displayMenuList() {
        System.out.println("---CHƯƠNG TRÌNH QUẢN LÝ DANH BẠ--");
        System.out.println("Chọn chức năng theo số (để tiếp tục):");
        System.out.println("1.Xem danh sách");
        System.out.println("2.Thêm mới");
        System.out.println("3.Cập nhật");
        System.out.println("4.Xóa");
        System.out.println("5.Tìm kiếm");
        System.out.println("6.Đọc từ File");
        System.out.println("7.Ghi vào File");
        System.out.println("8.thoát");
        System.out.println("Chọn chức năng: ");
    }
//    public void displayAll(){
//        DirectoryBookManage list = new DirectoryBookManage();
//
//    }
//    public void displayInputField(){
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Số điện thoại: ");
//        long phone = Long.parseLong(sc.next());
//        System.out.println("Nhập nhóm: ");
//        String group = sc.next();
//        System.out.println("Nhập họ tên: ");
//        String name = sc.next();
//        System.out.println("Giới tính Nam: 0 , Nữ: 1");
//        int sexType = sc.nextInt();
//        boolean isMale = false;
//        if (sexType == 0)
//            isMale = true;
//        else
//            isMale = false;
//        System.out.println("Nhập địa chỉ: ");
//        String address = sc.next();
//        System.out.println("Nhập email: ");
//        String email = sc.next();
//    }
}
