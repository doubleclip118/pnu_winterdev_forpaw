package com.hong.ForPaw.domain.Shelter;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Shelter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 보호소 등록 번호
    @Column
    private Long careRegNo;

    @Column
    private String name;

    @Column
    private String careTel;

    @Column
    private String careAddr;

    @Builder
    public Shelter(Long id, String name, String careTel, String careAddr) {
        this.name = name;
        this.careTel = careTel;
        this.careAddr = careAddr;
    }
}