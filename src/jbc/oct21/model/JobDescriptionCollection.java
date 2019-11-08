package jbc.oct21.model;

import jbc.oct21.ExtendsType.JobDescription;

import java.util.ArrayList;
import java.util.Collection;

public class JobDescriptionCollection extends ArrayList<JobDescription> {
    public JobDescriptionCollection(int initialCapacity) {
        super(initialCapacity);
    }

    public JobDescriptionCollection() {
    }

    public JobDescriptionCollection(Collection<? extends JobDescription> c) {
        super(c);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int index = 0; index < this.size(); index++) {
            sb.append("- Duty ").append(index+1).append(", ").append(this.get(index))
                    .append("\n");
        }

        return sb.toString();
    }
}
