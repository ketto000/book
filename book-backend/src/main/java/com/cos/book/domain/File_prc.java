package com.cos.book.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

//@AllArgsConstructor
//@NoArgsConstructor
@Entity
@Data
@Getter
@Setter
@Table(name="file_list")
@Accessors(chain = true)
public class File_prc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="filekey")
    private String filekey;

    @Column(name="fileuser")
    private String fileuser;

    @Column(name="filename")
    private String filename;

    @Column
    private String filepath;

    @Column
    private String filetype;

    @Column
    private String filedate;


    public  File_prc(){
        super();
    }

    public File_prc(String filekey,
                    String fileuser,
                    String filename,
                    String filepath,
                    String filetype,
                    String filedate)
    {
        this.filekey = filekey;
        this.fileuser = fileuser;
        this.filename = filename;
        this.filepath = filepath;
        this.filetype = filetype;
        this.filedate = filedate;
    }
}