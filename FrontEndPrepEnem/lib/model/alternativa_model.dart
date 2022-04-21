import 'package:prepenem/model/questao_model.dart';

class AlternativaModel {
  int? id;
  bool? correta;
  String? textoAlternativa;
  QuestaoModel? questaoModel;

  AlternativaModel(
      {this.id, this.correta, this.textoAlternativa, this.questaoModel});
}
