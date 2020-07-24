package com.sammdiev.demo.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Mahasiswa {

    @NonNull
    private String nim;

    @NonNull
    private String name;

    @NonNull
    private float ipk;

    @NonNull
    private String jurusan;

}
