# Git 工作流规范

## 1. 分支策略

- `main`：稳定主分支
- `feature/*`：功能开发分支
- `fix/*`：缺陷修复分支
- `chore/*`：工具链/脚手架/非业务调整分支

## 2. 日常流程

1. `git switch main`
2. `git pull`
3. `git switch -c feature/<name>`
4. 小步开发，小步提交
5. `git push -u origin feature/<name>`
6. 发起 PR/MR，评审通过后合并

## 3. 提交信息规范

格式：

`<type>(<scope>): <subject>`

类型：

- `feat`：新功能
- `fix`：缺陷修复
- `refactor`：重构
- `docs`：文档
- `test`：测试
- `chore`：构建/工具/杂项

示例：

- `feat(user): add user query endpoint`
- `fix(order): handle null payment status`
- `chore(services): init package structure`

## 4. 合并规则

- 禁止直接向 `main` 推送
- 至少一位评审通过
- CI/构建检查通过后方可合并

## 5. 回滚规则

- 共享分支回滚优先使用 `git revert <commit>`
- 避免在共享分支执行强推（force push）
