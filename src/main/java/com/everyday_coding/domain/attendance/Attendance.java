package com.everyday_coding.domain.attendance;

import com.everyday_coding.domain.BaseTimeEntity;
import com.everyday_coding.domain.member.Member;
import org.hibernate.annotations.ColumnDefault;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Attendance extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "attendance_id")
    private Long id;

    @ColumnDefault("false")
    private boolean attendanceCheck;

    @Temporal(TemporalType.TIME)
    @Column(nullable = true)
    private Date attendanceTime;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "member_id")
    private Member member;
}
