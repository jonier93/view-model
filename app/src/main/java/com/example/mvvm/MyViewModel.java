package com.example.mvvm;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MyViewModel extends ViewModel {
    private MutableLiveData<String> name;
    private MutableLiveData<String> apellido;

    public MyViewModel() {
        name = new MutableLiveData<>();
        apellido = new MutableLiveData<>();
    }

    public void setName(String name){
        this.name.setValue(name);
    }

    public void setApellido(String apellido) {
        this.apellido.setValue(apellido);
    }

    public LiveData<String> getName() {
        return name;
    }

    public LiveData<String> getApellido() {
        return apellido;
    }
}
