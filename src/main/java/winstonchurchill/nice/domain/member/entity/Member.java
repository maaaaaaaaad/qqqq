package winstonchurchill.nice.domain.member.entity;

import winstonchurchill.nice.domain.member.types.MemberGrade;


public class Member {
    private Long id;
    private String name;
    private MemberGrade grade;

    private int point;

    public Member(Long id, String name, MemberGrade grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MemberGrade getGrade() {
        return grade;
    }

    public void setGrade(MemberGrade grade) {
        this.grade = grade;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                ", point=" + point +
                '}';
    }
}
