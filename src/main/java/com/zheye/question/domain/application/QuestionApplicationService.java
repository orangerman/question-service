package com.zheye.question.domain.application;

import com.zheye.question.domain.application.command.CreateQuestionCommand;
import com.zheye.question.domain.application.result.CreateQuestionResult;
import com.zheye.question.domain.model.Question;
import com.zheye.question.domain.repository.QuestionRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * 问题applicationService.
 *
 * @author fanzhiqiang
 */
@Service
@Transactional
public class QuestionApplicationService {

    private final QuestionRepository questionRepository;

    public QuestionApplicationService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    /**
     * 创建问题.
     *
     * @param command - 创建问题命令
     * @return - 创建问题结果
     */
    public CreateQuestionResult createQuestion(CreateQuestionCommand command) {
        Question question = new Question(command.questionerId(), command.title(), command.detail());
        questionRepository.save(question);
        return new CreateQuestionResult(question.getId());
    }

}
