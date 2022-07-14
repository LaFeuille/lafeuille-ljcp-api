package org.lafeuille.ljcp.web.api.v1;

import org.lafeuille.ljcp.services.PersonService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/people")
class PeopleController {

    private final PersonService service;

    PeopleController(PersonService service) {
        this.service = service;
    }
}
