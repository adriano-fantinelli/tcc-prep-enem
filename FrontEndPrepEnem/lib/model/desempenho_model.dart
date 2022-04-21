import 'package:prepenem/model/questao_model.dart';
import 'package:prepenem/model/usuario_model.dart';

class DesempenhoModel {
  int? id;
  bool? respondidaCorretamente;
  UsuarioModel? usuarioModel;
  QuestaoModel? questaoModel;

  DesempenhoModel(
      {this.id,
      this.respondidaCorretamente,
      this.usuarioModel,
      this.questaoModel});
}
