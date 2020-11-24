package com.tastebuds.webapp.Storage;

import com.tastebuds.webapp.resources.Pairing;
import org.springframework.stereotype.Service;


@Service
public class PairingStorage {
    private PairingsRepository pairingRepo;

    public PairingStorage(PairingsRepository pairingRepo) {
        this.pairingRepo = pairingRepo;
    }

    public void savePairing(Pairing pairingToSave) {
        pairingRepo.save(pairingToSave);
    }

    public Pairing retrievePairingById(Long id) {
        return pairingRepo.findById(id).get();
    }
}
