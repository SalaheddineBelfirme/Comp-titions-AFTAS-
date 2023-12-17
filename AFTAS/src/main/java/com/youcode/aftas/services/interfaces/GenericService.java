package com.youcode.aftas.services.interfaces;

import java.util.List;

public interface GenericService<ID,R,Q> {
    public List<R> redAll();
    public R getOne(ID Id);
    public R create(Q Q);
    public R update( Q q);
    public boolean delete(ID id);

}