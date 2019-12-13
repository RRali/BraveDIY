//package rali.org.bravediy.validation.category;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.validation.Errors;
//import rali.org.bravediy.validation.ValidationConstants;
//import rali.org.bravediy.validation.annotation.Validator;
//
//@Validator
//public class CategoryAddValidator implements org.springframework.validation.Validator {
//
//    private final CategoryRepository categoryRepository;
//
//    @Autowired
//    public CategoryAddValidator(CategoryRepository categoryRepository) {
//        this.categoryRepository = categoryRepository;
//    }
//
//    @Override
//    public boolean supports(Class<?> aClass) {
//        return CategoryAddBindingModel.class.equals(aClass);
//    }
//
//    @Override
//    public void validate(Object o, Errors errors) {
//        CategoryAddBindingModel categoryAddBindingModel = (CategoryAddBindingModel) o;
//
//        if (categoryAddBindingModel.getName().length() < 3) {
//            errors.rejectValue(
//                    "name",
//                    ValidationConstants.NAME_LENGTH,
//                    ValidationConstants.NAME_LENGTH
//            );
//        }
//
//        if (this.categoryRepository.findByName(categoryAddBindingModel.getName()).isPresent()) {
//            errors.rejectValue(
//                    "name",
//                    String.format(ValidationConstants.NAME_ALREADY_EXISTS, "Category", categoryAddBindingModel.getName()),
//                    String.format(ValidationConstants.NAME_ALREADY_EXISTS, "Category", categoryAddBindingModel.getName())
//            );
//        }
//    }
//}
