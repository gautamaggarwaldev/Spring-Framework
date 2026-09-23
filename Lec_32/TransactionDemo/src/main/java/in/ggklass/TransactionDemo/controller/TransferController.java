package in.ggklass.TransactionDemo.controller;

import in.ggklass.TransactionDemo.entity.TransferRecord;
import in.ggklass.TransactionDemo.service.TransferService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/transfer")
public class TransferController {

    private TransferService transferService;

    public TransferController(TransferService transferService) {
        this.transferService = transferService;
    }

    @PostMapping
    public ResponseEntity<String> transferAmount(@RequestBody TransferRecord transferRecord) {
        transferService.transfer(transferRecord.getFromAccountId(),
                transferRecord.getToAccountId(),
                transferRecord.getAmount());

        return ResponseEntity.ok("transfer completed");
    }
}
