package com.marisbelkonrad.backend;

import org.springframework.batch.core.job.Job;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.job.parameters.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.Step;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class BatchConfig {
    private PlatformTransactionManager platformTransactionManager;

    public BatchConfig(PlatformTransactionManager platformTransactionManager) {
        this.platformTransactionManager = platformTransactionManager;
    }

    @Bean
    Job job(Step step, JobRepository jobRepository) {
        // O funcionamento do batch é muito baseado em máquina de estados.
        // Metadados com informações como quais jobs e steps já foram executados ficam armazenados no JobRepository
        return new JobBuilder("job", jobRepository)
                .start(step)
                .incrementer(new RunIdIncrementer())
                .build();

    }
}
