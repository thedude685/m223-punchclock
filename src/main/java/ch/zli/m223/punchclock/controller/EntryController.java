package ch.zli.m223.punchclock.controller;

import ch.zli.m223.punchclock.domain.ApplicationUser;
import ch.zli.m223.punchclock.domain.Entry;
import ch.zli.m223.punchclock.service.EntryService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Version 1.0
 * Author: Joel Angehrn
 */
@RestController
@RequestMapping("/entries")
public class EntryController {
    private EntryService entryService;

    public EntryController(EntryService entryService) {
        this.entryService = entryService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Entry> getAllEntries() {
        return entryService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Entry createEntry(@Valid @RequestBody Entry entry) {
        return entryService.createEntry(entry);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable Long id, ApplicationUser user) {
        entryService.deleteEntry(id, user);
    }

    @PutMapping("/edit")
    @ResponseStatus(HttpStatus.OK)
    public void editEntry(@Valid @RequestBody Entry entry, ApplicationUser user) {
        entryService.editEntry(entry, user);
    }
}
