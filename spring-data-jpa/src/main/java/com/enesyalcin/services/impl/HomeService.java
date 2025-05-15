package com.enesyalcin.services.impl;

import com.enesyalcin.DTOs.DTOHome;
import com.enesyalcin.DTOs.DTORoom;
import com.enesyalcin.entites.Home;
import com.enesyalcin.entites.Room;
import com.enesyalcin.repository.HomeRepository;
import com.enesyalcin.services.IHomeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class HomeService implements IHomeService {

    @Autowired
    private HomeRepository homeRepository;


    @Override
    public DTOHome getHomeById(Long id) {
        DTOHome dtoHome = new DTOHome();
        List<DTORoom> dtoRooms = new ArrayList<>();

        Optional<Home> optionalHome = homeRepository.findById(id);
        if (optionalHome.isEmpty()) {
            return null;
        }

        Home home = optionalHome.get();
        List<Room> rooms = home.getRoom();

        if (rooms != null && !rooms.isEmpty()) {
            for (Room room : rooms) {
                DTORoom dtoRoomDto = new DTORoom();
                BeanUtils.copyProperties(room, dtoRoomDto);
                dtoRooms.add(dtoRoomDto);
            }
        }

        BeanUtils.copyProperties(home, dtoHome);
        dtoHome.setRooms(dtoRooms);

        return dtoHome;
    }
}
