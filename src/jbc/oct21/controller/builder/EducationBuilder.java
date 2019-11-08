package jbc.oct21.controller.builder;

import jbc.oct21.ExtendsType.GraduationYear;
import jbc.oct21.ExtendsType.Major;
import jbc.oct21.ExtendsType.University;
import jbc.oct21.ExtendsType.DegreeType;
import jbc.oct21.model.Education;

import java.io.InputStream;
import java.io.PrintStream;

public class EducationBuilder extends Builder {

    Education education = new Education();

    public EducationBuilder() {
    }

    public EducationBuilder(Education education) {
        this.education = education;
    }

    public Education getEducation() {
        return education;
    }

    public void setEducation(Education education) {
        this.education = education;
    }

    public EducationBuilder set(DegreeType degreeType) {
        education.setDegreeType(degreeType);
        return this;
    }

    public EducationBuilder set(Major major) {
        education.setMajor(major);
        return this;
    }

    public EducationBuilder set(University university) {
        education.setUniversity(university);
        return this;
    }

    public EducationBuilder set(GraduationYear graduationYear) {
        education.setGraduationYear(graduationYear);
        return this;
    }

    public Education toEducation() {
        return education;
    }

    @Override
    public void auto(PrintStream printStream, InputStream inputStream) {
        DegreeType degreeType = new DegreeType();
        retrieve(printStream,inputStream, degreeType);
        this.set(degreeType);

        Major major = new Major();
        retrieve(printStream, inputStream, major);
        this.set(major);

        University university = new University();
        retrieve(printStream, inputStream, university);
        this.set(university);

        GraduationYear graduationYear = new GraduationYear();
        retrieve(printStream, inputStream, graduationYear);
        this.set(graduationYear);
    }
}
