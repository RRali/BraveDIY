package rali.org.bravediy.services.services.implementations;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;
import rali.org.bravediy.services.services.HashingService;

@Service
public class HashingServiceImpl implements HashingService {
    @Override
    public String hash(String str) {
        return DigestUtils.sha256Hex(str);
    }
}
