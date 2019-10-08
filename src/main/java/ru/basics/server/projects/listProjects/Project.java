package ru.basics.server.projects.listProjects;

import ru.basics.server.entity.contractor.Contractor;
import ru.basics.server.entity.user.User;

import javax.persistence.*;

@Entity
@Table
public class Project {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String numProject;

    @Column
    private String RP;

    @Column
    private Contractor endCostumer;

    public Project(String numProject, String RP, Contractor endCostumer) {
        this.numProject = numProject;
        this.RP = RP;
        this.endCostumer = endCostumer;
    }

    public String getNumProject() {
        return numProject;
    }

    public void setNumProject(String numProject) {
        this.numProject = numProject;
    }

    public String getRP() {
        return RP;
    }

    public void setRP(String RP) {
        this.RP = RP;
    }

    public Contractor getEndCostumer() {
        return endCostumer;
    }

    public void setEndCostumer(Contractor endCostumer) {
        this.endCostumer = endCostumer;
    }
}
