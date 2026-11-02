---
name: update-mod
description: 本模组的一般更新流程，大多数时候都是相同的流程
---

更新模组时默认有IDEA MCP浏览CGC Config Addon和Custom Gun Continued
- CGC Config Addon必须是core1.20.1分支，若为1.20.xforge则直接切换至core1.20.1
- Custom Gun Continued必须是core1.20.1或1.20.1分支
- 如果缺少IDEA环境或者分支错误，则需要先提示用户

## 更新流程

### 修改范围

更新流程应只修改以下文件

代码：
- `dev.xcolorful.cgcconfig.cloth.config.client.*.java`
- `dev.xcolorful.cgcconfig.cloth.config.common.*.java`
- `dev.xcolorful.cgcconfig.cloth.config.server.*.java`
- `dev.xcolorful.cgcconfig.cloth.init.ClothClientModConfig.java`

翻译键：
- `./core/src/main/resources/assets/cgcconfig/lang/en_us.json`
- `./core/src/main/resources/assets/cgcconfig/lang/zh_cn.json`

### 浏览内容

更新流程只需要浏览以下文件是否有变动

Custom Gun Continued
- `dev.xcolorful.customgun.core.config.*.java`
- `dev.xcolorful.customgun.client.config.*.java`
- `./docs/wiki/configuration/*.md`

### 检查变动

- 读取CGC Config Addon的`./gradle.properties`里的`customgun_version_range`
- 查找Custom Gun Continued `./changelog.md`该版本git提交日期
- 关注Custom Gun Continued中在这之后有变动/新增的代码类

### 应用修改

- 在CGC Config Addon相应代码位置，按照已有模式补充新增/变动的配置项
- 若配置项在Custom Gun Continued中标记`@Deprecated`，则在CGC Config Addon中删除该配置项
- CGC Config Addon的翻译键取自Custom Gun Continued `./docs/wiki/configuration/*.md`中的中英文翻译
- 翻译键路径效仿已有模式：`config.cgcconfig.{}.{}`+`config.cgcconfig.{}.{}.desc`；`config.cgcconfig.sync.{}.{}`+`config.cgcconfig.sync.{}.{}.desc`
- 同一个配置项内的翻译键需要保持跟Custom Gun Continued wiki中相同的顺序
- 配置项默认值需要跟Custom Gun Continued对齐

### 注意项

- 优先效仿CGC Config Addon已有实现，若出现不符合上述规则且在本次更新前的，则只向用户提出，而不要修改已有实现
- Custom Gun Continued wiki可能只对已有的配置项更改了翻译，wiki文件夹也需要检查git提交变动
- 若当前git工作区未修改`./gradle.properties`中的`customgun_version_range`，更新至
- 若`./gradle.properties`中的`customgun_maven`未更新，则尝试搜索CurseForge发布的1.20.1，搜不到再提示用户手动检查
- 更新时不需要更改`mod_version`

## 修改完之后

所有commit均使用本地账号，不得修改git设置或使用Claude等Agent账号

### 通知检查

- commit summary为"Port to CGC x.x.x"，不要push到远程，提示用户检查等待用户继续

### 写更新日志

当确认用户已提交本次commit到远程并通知继续后：
- 将`./gradle.properties`中的`mod_version`更改至Custom Gun Continued版本号
- 在`./changelog.md`中写更新信息，一般为`Port to Custom Gun Continued x.x.x`，标题/空行方式跟已有保持一致
- commit summary为"Version x.x.x"，commit tag为"x.x.x"，不要push到远程，等待用户继续

### 合并至高版本分支

通常本地未对1.20.1分支单独建文件夹，可以core1.20.1分支切换至1.20.xforge
- 将core1.20.1合并至其余分支
- 合并冲突应只有`./gradle.properties`中的`customgun_maven`，超出范围则停止并通知用户
- 尝试搜索CurseForge https://www.curseforge.com/minecraft/mc-mods/custom-gun-continued/files/all?page=1&pageSize=20 发布的1.20.1、1.20.2neoforge、1.21.1forge、1.21.1neoforge、1.21.10neoforge、1.21.11neoforge，如果获取不到则通知用户
- 用搜索到的这些maven信息（应只修改末尾一串数字）处理合并
- 等待每个版本构建（优先使用IDEA MCP），成功后通知用户验收，确认是否push到远程

在得到最后的用户确认后，将core1.20.1以外的分支push到远程

### 确认清理

在已经push到远程后，提示用户是否需要执行清理
- 将各分支构建完的产物复制到`D:\Temp-File\`，如果不存在文件夹，则通知是否需要另外放置
- 清理所有本地worktree中被`./.gitignore`忽略的文件，保留各worktree的`./.idea`、`./forge-compat/build/libs`、`./neoforge-compat/build/libs`
- 清理完成后，再将1.20.xforge切换回core1.20.1