package jbc.oct21.builder;

import jbc.oct21.ExtendsType.SkillName;
import jbc.oct21.ExtendsType.SkillProficiency;
import jbc.oct21.ExtendsType.YesNo;
import jbc.oct21.model.Skill;

import java.io.InputStream;
import java.io.PrintStream;

public class SkillBuilder extends Builder {
    Skill skill = new Skill();

    public SkillBuilder() {
    }

    public SkillBuilder(Skill skill) {
        this.skill = skill;
    }

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    public SkillBuilder set(SkillName skillName) {
        this.skill.setName(skillName);
        return this;
    }

    public SkillBuilder set(Skill.Proficiency skillProficiency) {
        this.skill.setProficiency(skillProficiency);
        return this;
    }

    public SkillBuilder set(SkillProficiency skillProficiency) {
        this.skill.setProficiency(skillProficiency.getValue());
        return this;
    }

    public Skill toSkill() {
        return skill;
    }



    @Override
    public void auto(PrintStream printStream, InputStream inputStream) {
        YesNo askUserYesOrNo = new YesNo();

            SkillName skillName = new SkillName();
            retrieve(printStream, inputStream, skillName);

            this.set(skillName);

            SkillProficiency skillProficiency = new SkillProficiency();
            retrieve(printStream, inputStream, skillProficiency);

           this.set(skillProficiency);


    }
}
