/**
 * 所有 API 的数据模型，定义到这个文件
 * 备注：可以先都定义到这个文件，后续再按模块拆分
 */

export interface AuthUser {
  id: number;
  username: string;
  avatar: string;
  token: string;
}
