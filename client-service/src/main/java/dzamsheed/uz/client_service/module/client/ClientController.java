package dzamsheed.uz.client_service.module.client;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clients")
@RequiredArgsConstructor
@SuppressWarnings("all")
public class ClientController {
    private final ClientService clientService;

    @GetMapping
    public HttpEntity<?> getAll() {
        try {
            return ResponseEntity.ok().body(clientService.getAll());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(409).body("Conflict");
        }
    }

    @PostMapping
    public HttpEntity<?> createOrUpdate(@RequestBody ClientRecord clientRecord) {
        try {
            return ResponseEntity.ok().body(clientService.createOrUpdate(clientRecord));
        } catch (IllegalArgumentException iae) {
            return ResponseEntity.badRequest().body(iae.getMessage());
        } catch (RuntimeException e) {
            return ResponseEntity.status(409).body(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(409).body("Conflict");
        }
    }


    @DeleteMapping("/{id}")
    public HttpEntity<?> delete(@PathVariable(name = "id") Integer id) {
        try {
            clientService.delete(id);
            return ResponseEntity.ok().body("Successfully deleted");
        } catch (RuntimeException e) {
            return ResponseEntity.status(409).body(e.getMessage());
        }
    }
}
