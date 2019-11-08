package jbc.oct21.builder;

import jbc.oct21.ExtendsType.*;

import jbc.oct21.model.Experience;

import java.io.InputStream;
import java.io.PrintStream;

public class ExperienceBuilder extends Builder {

    private Experience experience = new Experience();

    public ExperienceBuilder() {
    }

    public ExperienceBuilder(Experience experience) {
        this.experience = experience;
    }

    public Experience getExperience() {
        return experience;
    }

    public void setExperience(Experience experience) {
        this.experience = experience;
    }

    public ExperienceBuilder set(Title title) {
        this.experience.setTitle(title);
        return this;
    }

    public ExperienceBuilder set(Company company) {
        this.experience.setCompany(company);
        return this;
    }

    public ExperienceBuilder set(StartDate startDate) {
        this.experience.setStart(startDate);
        return this;
    }

    public ExperienceBuilder set(EndDate endDate) {
        this.experience.setEnd(endDate);
        return this;
    }

    public ExperienceBuilder append(JobDescription jobDescription) {
        this.experience.getJobDescriptionCollection().add(jobDescription);
        return this;
    }

    public Experience toExperience() {
        return experience;
    }

    @Override
    public void auto(PrintStream printStream, InputStream inputStream) {
        YesNo askUserYesOrNo = new YesNo();

        Title title = new Title();
        retrieve(printStream, inputStream, title);
        this.set(title);

        Company company = new Company();
        retrieve(printStream, inputStream, company);
        this.set(company);

        StartDate startDate = new StartDate();
        retrieve(printStream, inputStream, startDate);
        this.set(startDate);

        EndDate endDate = new EndDate();
        retrieve(printStream, inputStream, endDate);
        this.set(endDate);

        do {
            JobDescription jobDescription = new JobDescription();
            retrieve(printStream, inputStream, jobDescription);
            this.append(jobDescription);

            System.out.print("More Job Description ");
            retrieve(printStream, inputStream, askUserYesOrNo);
        } while(askUserYesOrNo.isYes());
    }
}
