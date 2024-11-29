package dev.playground.controller;

import dev.playground.persistence.dto.DatablockDto;
import dev.playground.persistence.dto.RefreshResponse;
import dev.playground.service.DatablockService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/datablock")
public class DatablockController {

    private final DatablockService datablockService;

    @Autowired
    public DatablockController(DatablockService datablockService) {
        this.datablockService = datablockService;
    }

    @PostMapping
    public ResponseEntity<DatablockDto> createDatablock(@Valid @RequestBody DatablockDto datablockDto) {
        return new ResponseEntity<>(datablockService.createDatablock(datablockDto), HttpStatus.CREATED);
    }

    @PutMapping(value = "id")
    public ResponseEntity<DatablockDto> updateDatablock(@PathVariable Integer id,
                                                        @Valid @RequestBody DatablockDto datablockDto) {

        return new ResponseEntity<>(datablockService.updateDatablock(id, datablockDto), HttpStatus.OK);
    }

    @DeleteMapping(value = "id")
    public ResponseEntity<HttpStatus> deleteDatablock(@PathVariable Integer id) {
        datablockService.deleteDatablock(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(value = "id")
    public ResponseEntity<RefreshResponse> refreshDatablock(@PathVariable Integer id) {
        return new ResponseEntity<>(datablockService.refreshDatablock(id), HttpStatus.OK);
    }

}
