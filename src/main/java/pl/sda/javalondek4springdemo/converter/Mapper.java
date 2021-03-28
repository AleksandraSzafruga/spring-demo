package pl.sda.javalondek4springdemo.converter;

public interface Mapper<E, D> {

    D fromEntityToDto(E e);

    E fromDtoToEntity(D dto);
}
