package com.javaRemote.project.database.pop;

import com.javaRemote.project.database.entities.Branch;
import com.javaRemote.project.database.service.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BranchPopulator implements CommandLineRunner {

    private Branch branch = new Branch(100,
            "branchAddress",
            null,
            null,
            null,
            null);

    @Autowired
    private BranchService branchService;

    @Override
    public void run(String... args) throws Exception {
        branchService.createBranch(branch);
    }
}
