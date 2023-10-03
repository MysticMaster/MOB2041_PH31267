package com.example.mob2041_soucre_code_ph31267.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {

    private static final String DbName = "PhuongNamLibrary";

    public DbHelper(@Nullable Context context) {
        super(context, DbName, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //  tạo bảng loại sách -----------------------------
        String createLoaiSach = "CREATE TABLE LoaiSach(" +
                "maLoaiSach INTEGER PRIMARY KEY AUTOINCREMENT," +
                "tenLoaiSach TEXT NOT NULL );";
        db.execSQL(createLoaiSach);

        db.execSQL("INSERT INTO LoaiSach VALUES" +
                "(1,'Văn học')," +
                "(2,'Kinh tế')," +
                "(3,'Ngoại ngữ')," +
                "(4,'Công nghệ thông tin');");

        // tạo bảng sách -----------------------------------
        String createSach = "CREATE TABLE Sach(" +
                "maSach INTEGER PRIMARY KEY AUTOINCREMENT," +
                "tenSach TEXT NOT NULL," +
                "giaMuon INTEGEER NOT NULL," +
                "maLoaiSach INTEGER," +
                "FOREIGN KEY (maLoaiSach) REFERENCES LoaiSach (maLoaiSach) ON DELETE SET NULL);";
        db.execSQL(createSach);

        db.execSQL("INSERT INTO Sach VALUES" +
                "(1,'Số đỏ',12000,1)," +
                "(2,'Lập trình JAVA cơ bản',33000,4)," +
                "(3,'360 động từ bất quy tắc',21000,3)," +
                "(4,'Phi lý trí',25000,2)," +
                "(5,'Clean code',23000,4);");

        // tạo bảng thủ thư ------------------------------------
        String createThuThu = "CREATE TABLE ThuThu(" +
                "maThuThu TEXT PRIMARY KEY," +
                "hoThuThu TEXT NOT NULL," +
                "tenThuThu TEXT NOT NULL," +
                "tenDangNhap TEXT UNIQUE NOT NULL," +
                "matKhau TEXT NOT NULL," +
                "trangThaiThuThu INTEGER NOT NULL," +
                "phanQuyen INTEGER NOT NULL);";
        db.execSQL(createThuThu);

        db.execSQL("INSERT INTO ThuThu VALUES" +
                "('ADMIN','Đinh','Ngọc Anh','ADMINISTRATOR','123456789',1,0)," +
                "('THUTHU1','Cao','Minh Thành','THANHTT01','123456789',1,1)," +
                "('THUTHU2','Nguyễn','Tuấn An','ANTT02','123456789',1,1);");

        // tạo bảng thành viên -----------------------------------
        String createThanhVien = "CREATE TABLE ThanhVien(" +
                "maThanhVien INTEGER PRIMARY KEY AUTOINCREMENT," +
                "hoTenThanhVien TEXT NOT NULL," +
                "namSinh INTEGER);";
        db.execSQL(createThanhVien);

        db.execSQL("INSERT INTO ThanhVien VALUES" +
                "(1,'Nông Văn Anh', 1999)," +
                "(2,'Lý Thượng Sách', 2003)," +
                "(3,'Thủy Kính', 1998)," +
                "(4,'Thủy Thượng Phiêu', 2002)," +
                "(5,'Tịnh Thổ Nhất Tâm', 1998);");

        // tạo bảng phiếu mượn ------------------------------------
        String createPhieuMuon = "CREATE TABLE PhieuMuon(" +
                "maPhieuMuon INTEGER PRIMARY KEY," +
                "trangThaiPhieuMuon INTEGER NOT NULL," +
                "giaMuon INTEGER," +
                "ngayMuon DATE NOT NULL," +
                "maThanhVien INTEGER," +
                "maSach INTEGER," +
                "maThuThu TEXT," +
                "FOREIGN KEY (maThanhVien) REFERENCES ThanhVien (maThanhVien) ON DELETE SET NULL," +
                "FOREIGN KEY (maSach) REFERENCES Sach (maSach) ON DELETE SET NULL," +
                "FOREIGN KEY (maThuThu) REFERENCES ThuThu (maThuThu));";
        db.execSQL(createPhieuMuon);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion != newVersion) {
            String dropLoaiSach = "DROP TABLE IF EXISTS LoaiSach";
            String dropSach = "DROP TABLE IF EXISTS Sach";
            String dropThuThu = "DROP TABLE IF EXISTS ThuThu";
            String dropThanhVien = "DROP TABLE IF EXISTS ThanhVien";
            String dropPhieuMuon = "DROP TABLE IF EXISTS PhieuMuon";

            db.execSQL(dropLoaiSach);
            db.execSQL(dropSach);
            db.execSQL(dropThuThu);
            db.execSQL(dropThanhVien);
            db.execSQL(dropPhieuMuon);
            //  Gọi lại phương thức tạo bảng
            onCreate(db);
        }
    }
}
