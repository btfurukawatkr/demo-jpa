package com.example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Child;
import com.example.entity.Parent;
import com.example.repository.ChildRepository;
import com.example.repository.ParentRepository;

@SpringBootApplication
public class DemoJpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoJpaApplication.class, args);
    }

    @RestController
    static class DemoRestController {

        private final Logger LOGGER = LoggerFactory.getLogger("com.example.DemoJpaApplication.DemoRestController");

        private final ParentRepository parentRepository;
        private final ChildRepository childRepository;
        private final EntityManagerFactory entityManagerFactory;

        public DemoRestController(ParentRepository parentRepository, ChildRepository childRepository,
                EntityManagerFactory entityManagerFactory) {
            this.parentRepository = parentRepository;
            this.childRepository = childRepository;
            this.entityManagerFactory = entityManagerFactory;
        }

        @GetMapping("/deleteAll")
        @Transactional
        public void deleteAll() {
            childRepository.deleteAll();
            parentRepository.deleteAll();
        }

        @GetMapping("/initParent")
        @Transactional
        public void initParent() {
            long cnt = count();

            if (cnt == 0) {
                parentRepository.save(new Parent());
            }
        }

        @GetMapping("/initChild")
        @Transactional
        public void init() {
            long cnt = childRepository.count();

            if (cnt == 0) {
                Iterable<Parent> parents = parentRepository.findAll();
                if (!parents.iterator().hasNext()) {
                    LOGGER.error("!!!UNEXPECTED ERROR!!!");
                    return;
                }
                Parent parent = parents.iterator().next();

                Child child1 = new Child(10, parent);
                Child child2 = new Child(20, parent);
                Child child3 = new Child(30, parent);

                childRepository.save(child1);
                childRepository.save(child2);
                childRepository.save(child3);
            }
        }

        @GetMapping("/demo1")
        @Transactional
        public String demo1() {
            long cnt = count();
            if (cnt == 0) {
                LOGGER.error("!!!NO DATA!!!");
                return "failure:demo1";
            }

            Iterable<Parent> parents = parentRepository.findAll();
            if (!parents.iterator().hasNext()) {
                LOGGER.error("!!!UNEXPECTED ERROR!!!");
                return "failure:demo1";
            }
            Parent find1 = parents.iterator().next();
            if (find1.getChildren().size() != 3) {
                LOGGER.error("!!!INVALID DATA!!!");
                return "failure:demo1";
            }

            return "success:demo1";
        }

        @GetMapping("count")
        public long count() {
            long pCnt = parentRepository.count();
            long cCnt = childRepository.count();
            LOGGER.info("Parent:" + String.valueOf(pCnt));
            LOGGER.info("Child:" + String.valueOf(cCnt));
            return pCnt;
        }

        @GetMapping("/demo2")
        public void demo2() {
            // persist parent entity in a transaction

            EntityManager em = entityManagerFactory.createEntityManager();
            em.getTransaction().begin();

            Parent parent = new Parent();
            em.persist(parent);
            int id = parent.getId();

            em.getTransaction().commit();
            em.close();

            // relate and persist child entity in a new transaction
            em = entityManagerFactory.createEntityManager();
            em.getTransaction().begin();
            
            parent = em.find(Parent.class, id);
            // parent.getChildren().size();
            Child child = new Child();
            child.setParent(parent);
            parent.getChildren().add(child);
            em.persist(child);

            System.out.println(parent.getChildren());

            em.getTransaction().commit();
            em.close();
        }
    }
}