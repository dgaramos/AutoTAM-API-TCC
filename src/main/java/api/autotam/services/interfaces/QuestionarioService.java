package api.autotam.services.interfaces;

import api.autotam.model.Questionario;

public interface QuestionarioService {

    void saveQuestionario(Questionario questionario);

    void updateQuestionario(Questionario questionario);

    void deleteQuestionario (int idQuestionario);

    Questionario findById(int idQuestionario);

}