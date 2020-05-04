package com.mimmarcelo.ceep;

public interface M {
    interface constant{
        int invalid_position = -1;
    }

    interface extra{
        String note_obj = "note_obj";
        String position = "position";
    }

    interface request{
        int create_note = 1;
        int update_note = 2;
    }
}
