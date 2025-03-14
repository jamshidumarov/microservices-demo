package dzamsheed.uz.client_service.module.client;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientService {
    private final ClientRepository clientRepository;

    public List<ClientRecord> getAll() {
        return clientRepository.findAll().stream().map(Client::toRecord).toList();
    }

    public ClientRecord createOrUpdate(ClientRecord clientRequest) {
        if (clientRequest == null || clientRequest.email() == null || clientRequest.phoneNumber() == null)
            throw new IllegalArgumentException("Bad request");


        Client client;
        if (clientRequest.id() != null) {
            client = clientRepository.findById(clientRequest.id()).orElse(null);
            if (client == null)
                throw new RuntimeException("No user found");
            
            if (clientRepository.existsByEmailAndIdNot(clientRequest.email(), client.getId()))
                throw new RuntimeException("User already exists with this email");

            if (clientRepository.existsByPhoneNumberAndIdNot(clientRequest.phoneNumber(), client.getId()))
                throw new RuntimeException("User already exists with this phone number");
        } else {
            client = new Client();
            if (clientRepository.existsByEmail(clientRequest.email()))
                throw new RuntimeException("User already exists with this email");

            if (clientRepository.existsByPhoneNumber(clientRequest.phoneNumber()))
                throw new RuntimeException("User already exists with this phone number");
        }

        client.setName(clientRequest.name());
        client.setBirthDate(clientRequest.birthDate());
        client.setEmail(clientRequest.email());
        client.setPhoneNumber(clientRequest.phoneNumber());
        return clientRepository.save(client).toRecord();
    }

    public void delete(Integer id) {
        try {
            clientRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Conflict");
        }
    }
}
